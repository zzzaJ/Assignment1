# Makefile for Assignment 1

JAVAC = javac 

JAVADOC = javadoc

BIN = ./bin/

SRC = ./src/

DOC = ./doc/

DOCFILES = ./src/BinarySearchTree.java ./src/PrintIt.java ./src/SearchIt.java ./src/SearchItLinear.java

TEST = ./test/

TESTFILES = 

JAVAFLAGS = -g -d $(BIN) -cp $(SRC)

COMPILE = $(JAVAC) $(JAVAFLAGS)

JAVA_FILES = $(subst $(SRC), $(EMPTY), $(wildcard $(SRC)*.java))

CLASS_FILES = $(JAVA_FILES:.java=.class)

all : $(addprefix $(BIN), $(CLASS_FILES)) doc

$(BIN)%.class : $(SRC)%.java
	$(COMPILE) $<

doc: $(BIN)
	javadoc -d $(DOC) $(DOCFILES)  

test: $(TEST)
	javac 

clean : 
	rm -rf $(BIN)*.class $(DOC)* 
