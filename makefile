# Escrito por mim, Compilado por Deus...

# Compiler
JAVAC = javac

# Compiler flags
JFLAGS = -g

# Source files
SOURCES = $(wildcard *.java)

# Class files
CLASSES = $(SOURCES:.java=.class)

# Default target
all: $(CLASSES)

# Compile
%.class: %.java
	$(JAVAC) $(JFLAGS) $<

# PDF
pdf:
	pandoc --pdf-engine=xelatex grr20203959.md -o grr20203959.pdf

# Clean
clean:
	rm -f *.class
	rm -f ./jogo/*.class
	rm -f ./jogo/Board/*.class
	rm -f ./jogo/Coordinate/*.class
	rm -f ./jogo/Cores/*.class
	rm -f ./jogo/Entities/*.class
	rm -f ./jogo/Sector/*.class

# Run
run:
	java ./jogo/Main
