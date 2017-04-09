BIN = bin
SRC = src
TEST = test
DOC = doc

TESTING = /home/dino/cs2001f/Assignment1/HandIn/test/

JAVAC = javac
JFLAGS = -g -d $(BIN) -cp $(BIN):$(JUNIT)

DOCFILES = ./src/BinarySearchTree.java ./src/PrintIt.java ./src/SearchIt.java ./src/SearchItLinear.java

JUNIT =/home/dino/cs2001f/JUnit/junit-4.12.jar:/home/dino/cs2001f/JUnit/hamcrest-core-1.3.jar

vpath %.java $(SRC):$(TEST)

vpath %.class $(BIN)

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $(JFLAGS) $<

CLASSES = BinarySearchTree.class PrintIt.class SearchIt.class \
	  SearchItLinear.class

classes: $(CLASSES:.java=.class)

#The following creates the .class files for the tests and moves them to \test\. so that the tests can run with pre-specified testdata and queries files, in order to test functionality.

test_class: classes TestBinarySearchTree.class \
            TestPrintIt.class \
	    TestSearchItLinear.class TestSearchIt.class
	mv ./bin/Test*.class ./test/

test: test_class
	java -cp $(TESTING):$(BIN):$(JUNIT) org.junit.runner.JUnitCore TestBinarySearchTree TestPrintIt TestSearchIt TestSearchItLinear

doc: $(BIN)
	javadoc -d $(DOC) $(DOCFILES)  

clean:
	rm -rf $(BIN)/*.class $(DOC)/* $(TEST)/*.class
