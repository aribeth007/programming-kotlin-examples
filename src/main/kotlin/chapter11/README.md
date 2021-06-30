# Internal Iteration and Lazy Evaluation
Internal Iterators: 
- iterations on autopilot :P
- higher order functions => we pass lambdas to functions that perform iteration tasks
- performance may be a drawback when using internal iterators (might do other computations)
- Sequences: internal iterators that look the same as other internal iteration but internally they are implemented differently (they are lazy, they evaluate parts of the iteration only if necessary)

Example of higher order functions:
- filter() : the lambda passed to filter decides the elements that get selected


