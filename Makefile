JCC = javac

default: ./*.class

./*.class: ./*.java
	$(JCC)  ./*.java


clean:
	$(RM) ./*.class
