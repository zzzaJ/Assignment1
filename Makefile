# Makefile for Assignment 1

JAVAC = javac 

JAVADOC = javadoc

BIN = ./bin/

SRC = ./src/

DOC = ./doc/

JAVAFLAGS = -g -d $(BIN) -cp $(SRC)

COMPILE = $(JAVAC) $(JAVAFLAGS)

JAVA_FILES = $(subst $(SRC), $(EMPTY), $(wildcard $(SRC)*.java))

CLASS_FILES = $(JAVA_FILES:.java=.class)

all : $(addprefix $(BIN), $(CLASS_FILES)) doc

$(BIN)%.class : $(SRC)%.java
	$(COMPILE) $<

doc: $(BIN)
	javadoc -d $(DOC) ./src/*  

clean : 
	rm -rf $(BIN)*.class $(DOC)* 