/*-------------------------------------------------------------------------*
 *---									---*
 *---		headers.h						---*
 *---									---*
 *---	    This file contains the #includes and definitions common to	---*
 *---	the spaceInvadersServer and spaceInvadersClient programs. 	---*
 *---									---*
 *---	----	----	----	-----	----	----	----	----	---*
 *---									---*
 *---	Version 1.0		2011 Feb 23		Joseph Phillips	---*
 *---									---*
 *---	Version 2.0		2014 November 06	Joseph Phillips	---*
 *---                                                                   ---*
 *---      Adapted for multi-threaded, more self-contained client and	---*
 *---	multi-process server.						---*
 *---                                                                   ---*
 *-------------------------------------------------------------------------*/



/*---									---*
 *---			Common inclusion:				---*
 *---									---*/

#include <stdlib.h>		// For standard libraries
#include <stdio.h>		// For I/O
#include <string.h>		// For memcpy()
#include <ctype.h>              // For isdigit() and isspace()

#include <sys/socket.h>		// For socket()
#include <netinet/in.h>		// For sockaddr_in and htons()

#include <errno.h>		// For errno var

#include <ncurses.h>	        // For window control

using namespace std;



/*---		(re-)Declaration of C I/O functions whose		---*
 *---		 names would be mangled by C++ compiler:		---*/

extern "C"
{
    int   close(int );
    int   read (int , void*, size_t);
    int   write(int , const void*, size_t);
}



/*---									---*/
/*---	 		Common types and constants:			---*/
/*---									---*/

/*---			Generic size related constants:			---*/

const int		SIZE16		= sizeof(short);

const int		SIZE32		= sizeof(int);



/*---			Invader related types and constants		---*/
/*---			Invaders are organized by ranks and files.
 Ranks go from 0 to NUM_INVADER_RANKS-1,
 with each rank occupying one row.
 Files go from 0 to NUM_INVADERS_PER_RANK-1,
 with each file occupying one column.		---*/

const short		ILLEGAL_RANK		= -1;

const short		ILLEGAL_FILE		= -1;

const int		NUM_INVADER_FRAMES  	= 4;

const short		ROWS_BETWEEN_INVADER_RANKS
= 1;

const short		NUM_INVADERS_PER_RANK	= 12;

const short		NUM_INVADER_RANKS	= 3;

const short		INIIAL_BOTTOMMOST_INVADER_RANK_ROW
= (ROWS_BETWEEN_INVADER_RANKS+1)
* NUM_INVADER_RANKS;

const short		COLS_PER_INVADER	= 3;

const short		COLS_BETWEEN_INVADERS	= 2;

const short		EXTRA_COLS_ON_ROW_BEYOND_FULL_RANK_OF_INVADERS
= (COLS_PER_INVADER +
   COLS_BETWEEN_INVADERS
   ) *
NUM_INVADERS_PER_RANK;

const int		MAX_NUM_INVADER_BULLETS	= 3;

const int		RECIPROCAL_INVADER_SHOOT_PROB
= 2*NUM_INVADERS_PER_RANK;


/*---			Board-related types and constants:		---*/

const short		MAX_NUM_ROWS		= 30;

const short		DEFAULT_NUM_ROWS	= MAX_NUM_ROWS;

const short             ILLEGAL_ROW             = -1;

const short		MAX_NUM_COLS		= (COLS_PER_INVADER +
                                       COLS_BETWEEN_INVADERS
                                       ) *
NUM_INVADERS_PER_RANK+
EXTRA_COLS_ON_ROW_BEYOND_FULL_RANK_OF_INVADERS;

const short		DEFAULT_NUM_COLS	= MAX_NUM_COLS;

const short             ILLEGAL_COL             = -1;

const short		LEFT_BORDER_COL		= 0;

const short		RIGHT_BORDER_COL	= LEFT_BORDER_COL
+ DEFAULT_NUM_COLS
+ 1;

const short		TOP_BORDER_ROW		= 0;



/*---			Defender-craft-related types and constants:	---*/

const int		DEFENDER_WIDTH			= 3;



/*---			Request-related types and constants:		---*/

const char		QUIT_CHAR	        = (char)0x1B;

typedef unsigned char	RequestPrefix;

const RequestPrefix	REQUEST_CONNECT_REQUEST	= 'C';

const RequestPrefix	DISCONNECT_REQUEST	= 'D';

const RequestPrefix	LEFT_REQUEST		= 'l';

const RequestPrefix	RIGHT_REQUEST		= 'r';

const RequestPrefix	SHOOT_REQUEST		= 's';

typedef	short		request_t;

const int		REQUEST_LENGTH		= sizeof(request_t);

const int		RIGHT_INC		= +1;

const int		LEFT_INC		= -1;



/*---			Update-related types and constants:		---*/

typedef unsigned char	UpdatePrefix;

const UpdatePrefix	CONNECTION_DENIED_UPDATE	= '!';

/*  Whole board update syntax:
 "ww"						+
 bottom-most invader rank row (16-bit int)		+
 left-most invader col (16-bit int)			+
 1st rank invader boolean packed bit 32-bit int	+
 . . .                                          	+
 last rank invader boolean packed bit 32-bit int	+
 1st invader bullet row (16-bit int)	       		+
 1st invader bullet col (16-bit int)	       		+
 . . .
 last invader bullet row (16-bit int)       		+
 last invader bullet col (16-bit int)       		+
 defender 0 col (16-bit int)				+
 defender 1 col (16-bit int)				+
 defender 0's bullet row (16-bit int)        	+
 defender 0's bullet col (16-bit int)        	+
 defender 1's bullet row (16-bit int)        	+
 defender 1's bullet col (16-bit int)
 */
const UpdatePrefix      BEGIN_WHOLE_BOARD_UPDATE        = 'w';

const int		MAX_UPDATE_LEN	=
sizeof(BEGIN_WHOLE_BOARD_UPDATE)+
sizeof(BEGIN_WHOLE_BOARD_UPDATE)+
sizeof(short)			+ // Invader rank row
sizeof(short)			+ // Invader col
NUM_INVADER_RANKS * sizeof(int)	+ // boolean packed bit
MAX_NUM_INVADER_BULLETS *	  // Invader bullet
(sizeof(short) + sizeof(short))+ //  rows & cols
sizeof(short)	+ 		  // Defender cols
(sizeof(short) + sizeof(short)); // Defender bullet
//  rows & cols


/* Differential board update syntax
 "dd"					+
 1st invader bullet row (16-bit int)	       	+
 1st invader bullet col (16-bit int)	       	+
 . . .
 last invader bullet row (16-bit int)       	+
 last invader bullet col (16-bit int)       	+
 defender col (16-bit int)			+
 defender's bullet row (16-bit int)		+
 defender's bullet col (16-bit int)
 */
const UpdatePrefix      BEGIN_DIFFERENTIAL_BOARD_UPDATE = 'd';

const UpdatePrefix	BEEP_UPDATE			= 'B';

const UpdatePrefix	DISCONNECT_UPDATE	        = 'D';

const UpdatePrefix	HAVE_WON_UPDATE			= 'W';

/* Defender killed update syntax
 "KK"				+
 defender num (16-bit int)	+
 defender col (16-bit int)
 */
const UpdatePrefix	DEFENDER_KILLED_UPDATE		= 'K';

/* Invader killed update syntax
 "kk"				+
 invader rank (16-bit int)	+
 invader file (16-bit int)
 */
const UpdatePrefix	INVADER_KILLED_UPDATE		= 'k';

// Error update syntax
// "EE"
// text in English
const UpdatePrefix	ERROR_UPDATE			= 'E';


/*---		Timing and update-interval related constants:		---*/

const int	INTERVAL_DELAY_MICROSECS       	= 50000;

const int	NUM_INTERVALS_TO_MOVE_BULLET	= 1024;

const int	NUM_INVADER_SPEEDS		= 4;

const int	FASTEST_INVADER_SPEED		= 32768;

const int	NUM_INTERVALS_TO_MOVE_INVADERS[NUM_INVADER_SPEEDS]
= {FASTEST_INVADER_SPEED*8,
    FASTEST_INVADER_SPEED*4,
    FASTEST_INVADER_SPEED*2,
    FASTEST_INVADER_SPEED*1
};

const int	MIN_NUM_INVADERS_PER_SPEED[NUM_INVADER_SPEEDS]
= {NUM_INVADERS_PER_RANK,
    NUM_INVADERS_PER_RANK / 2,
    NUM_INVADERS_PER_RANK / 4,
    NUM_INVADERS_PER_RANK / 8
};

const int	INVERSE_WHOLE_UPDATE_INVERSE_FREQUENCY
= 16;



/*---		Socket and communication-related types and constants:	---*/

#define         INITIAL_HOST	                "localhost.localdomain"

const int	INITIAL_PORT                    = 20000;

const int       ERROR_DESCRIPTOR                = -1;

const int	MAX_NUM_GUI_COMMUNICATION_SOCKET_BIND_ATTEMPTS
= 256;

const int       MAX_NUM_WAITING_CLIENTS         = 5;

const char	HOST_NAME_PORT_SEPARATORY_CHAR	= ':';

const char	IP_ADDR_SUBNET_SEPARATORY_CHAR	= '.';


/*---		Miscellaneous constants:				---*/

const int	C_STRING_MAX	= 256;



/*---		In spaceInvadersCommon.cpp:				---*/

//  PURPOSE:  To tell the rows on which the defenders appear.
const short	defenderRow			=  MAX_NUM_ROWS-2;


extern char     	cText[C_STRING_MAX];

//  PURPOSE:  To return the row of an invader of rank 'rank' given that the
//	bottommost rank is at row 'bottommostInvaderRankRow'.
inline
short	getInvaderRowGivenRankAndBottommostRankRow
(short	rank,
 short	bottommostInvaderRankRow
 )
throw()
{ return(bottommostInvaderRankRow -
         rank * (1 + ROWS_BETWEEN_INVADER_RANKS)
         );
}


//  PURPOSE:  To return the leftmost column of an invader of file 'file' given
//	that the leftmost invader column is at col 'leftMostInvaderCol'.
inline
short	getInvadersLeftmostColGivenFileAndLeftmostCol
(short	file,
 short	leftMostInvaderCol
 )
throw()
{ return(leftMostInvaderCol	+
         file * (COLS_BETWEEN_INVADERS+COLS_PER_INVADER)
         );
}


/*---		Inclusions of space invader class headers:		---*/

//  PURPOSE:  To be the "robust" version of read() in the manner advocated by
//	Bryant and O'Hallaron.  'fd' tells the file descriptor from which to
//	read.  'usrbuf' tells the buffer into which to read.  'n' tells the
//	length of 'usrbuf'.  Returns number of bytes read or -1 on some type
//	of error.
ssize_t rio_read	(int	fd,
                     char*	usrbuf,
                     size_t	n
                     )
throw();
