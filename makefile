JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class: 
	$(JC) $*.java

CLASSES = Start.java RailRoad.java Property.java Land.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
