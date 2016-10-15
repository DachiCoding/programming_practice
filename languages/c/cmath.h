_CRTIMP double _cdecl sin (double);
_CRTIMP double _cdecl cos (double);
_CRTIMP double _cdecl tan(double);
_CRTIMP double _cdecl sinh (double);
_CRTIMP double _cdecl cosh (double);
_CRTIMP double _cdecl tanh (double);
_CRTIMP double _cdecl asin(double);
_CRTIMP double _cdecl acos (double);
_CRTIMP double _cdecl atan (double);
_CRTIMP double _cdecl atan2 (double,double);
_CRTIMP double _cdecl exp (double);
_CRTIMP double _cdecl log (double);
_CRTIMP double _cdecl log10 (double);
_CRTIMP double _cdecl pow (double,double);
_CRTIMP double _cdecl sqrt (double);
_CRTIMP double _cdecl ceil (double);
_CRTIMP double _cdecl floor (double);
_CRTIMP double _cdecl fabs (double);
_CRTIMP double _cdecl ldexp (double,int);
_CRTIMP double _cdecl frexp (double,int*);
_CRTIMP double _cdecl modf(double,double*);
_CRTIMP double _cdecl fmod(double,double);

#define PI 3.14159265358979323846
#define e 2.7182818284590452354
#define ln_2 0.69314718055994530942
#define ln_10 2.30258509299404568402

#define fabs(a) (a) > 0 ? (a): (-(a))

double pow(double a, int n){
     if (n < 0) return 1/pow(a,-n);
     double res = 1.0;
     while(n){
         if(n&1) res *= a;
         a *= a;
         n >>= 1;
     }
     return res;
}


