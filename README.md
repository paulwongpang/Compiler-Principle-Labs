# Compiler Principle Labs
## Lab1: Lexical Analyzer Programming<br>
* Input: Stream of characters; REs(The number of REs is decided by yourself)<br>
* Output: Sequence of tokens<br>
* Classes of words are defined by yourself<br>
* Error handling may be included<br>
## Lab1 Method: Programming based on FA
* Define some REs by yourself<br>
* Convert REs into NFAs<br>
* Merge these NFAs into a single NFA
* Convert the NFA into a DFA with minimum states
* Programming based on the DFA with minimum states
<br>
## Lab2: Syntax Parser Programming<br>
* Input: Stream of characters; CFG(Combination of CFGs of some classes of sentences)<br>
* Output: Sequence of derivations(if top-down syntax analyzing methods are used)<br>
* Classes of sentences are defined by yourself<br>
* Error handling may be included<br>
## Lab2 Method: LL(1)
* Construct LL(1) parsing table based on the CFG
* Design the program using LL(1) paring table
