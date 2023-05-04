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
	rm -f ./Board/*.class
	rm -f ./Entities/*.class

# Run
run:
	java Main
