### To generate the graph of the dependency between all modules of project:

`mvn com.github.ferstl:depgraph-maven-plugin:3.0.1:aggregate -DreduceEdges=false -Dscope=compile "-Dincludes=com.food.ordering.system:*"`



### Application Properties that should be reviewed
    open-in-view
    binaryTransfer
    reWriteBatchedInserts
    stringtype