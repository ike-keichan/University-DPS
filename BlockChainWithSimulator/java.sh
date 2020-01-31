#!/bin/bash
CMD='/Library/Java/JavaVirtualMachines/jdk-13.0.1.jdk/Contents/Home/bin/java'
LIB='.:./commons-codec-1.13/commons-codec-1.13.jar'
${CMD} -cp ${LIB} $@ 
