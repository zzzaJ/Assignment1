BIN = ./bin/
SRC = ./src/
TEST = ./test/
DOC = ./doc/
JAVAC = javac
JAVAFILES = ./src/PrintIt.java ./src/SearchIt.java ./src/SearchItLinear.java ./src/BinarySearchTree.java
JFLAGS = -g -d $(BIN) -cp $(SRC)

DOCFILES = ./src/BinarySearchTree.java ./src/PrintIt.java ./src/SearchIt.java ./src/SearchItLinear.java

JUNIT =./src/junit-4.12.jar:./src/hamcrest-core-1.3.jar

vpath %.java ./src/

vpath %.class $(BIN):$(TEST)

.SUFFIXES: .java .class

$(TEST)Test%.class : $(SRC)Test%.java
	$(JAVAC) -g -d $(TEST) -cp $(SRC):$(JUNIT) $<

.java.class:
	$(JAVAC) $(JFLAGS):$(JUNIT) $<

all: PrintIt.class SearchIt.class SearchItLinear.class TestBinarySearchTree.class TestPrintIt.class TestSearchIt.class TestSearchItLinear.class mvtest doc 
#managed to achieve test*.class to test fldr, but using mv command only
doc: $(BIN)
	javadoc -d $(DOC) $(DOCFILES)  

mvtest: $(TEST)
	mv ./bin/Test*.class ./test/
