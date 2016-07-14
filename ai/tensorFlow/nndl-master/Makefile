# Makefile
#

TEX = xelatex
MKIDX = makeindex
RM = rm -rf
MAKE = make
TARGET = nndl-ebook.pdf
SOURCES := $(wildcard *.tex)

IMAGEDEPS := $(wildcard images/*.tex)
IMAGEDEPS += $(wildcard images/*.png)
IMAGEDEPS += $(wildcard images/*.jpeg)

.PHONY: all graphics

all: graphics $(TARGET)

$(TARGET): $(SOURCES) $(IMAGEDEPS)
	$(TEX) $(basename $@)
	$(MKIDX) $(basename $@)
	$(TEX) $(basename $@)
	$(TEX) $(basename $@)

graphics:
	$(MAKE) -C images

clean:
	$(MAKE) -C images clean
	$(RM) *.pdf
	$(RM) *.aux
	$(RM) *.log
	$(RM) *.out
	$(RM) *.toc
	$(RM) *.idx
	$(RM) *.ilg
	$(RM) *.ind
