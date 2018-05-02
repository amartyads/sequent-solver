PROJECT TITLE: Sequent calculus solver

GIT LINK: https://github.com/amartyads/sequent-solver.git

HOW TO START THIS PROJECT:
1) unzip the contents
2) navigate to folder
3) run by
java Main "<propositional logic formula>"

AUTHORS: Amartya DS 03694265, Arun S 03698283

USER INSTRUCTIONS:
The main method is in the Main class, and it takes one propositional logic formula as commandline argument.
At every step, the current sequent is shown, along with the rule that will be used next.
When the rules call for a split, it is shown as a left and right child.
If a formula does not hold, the prover exits.

The permissible alphabet is given below:

Top : T
Bottom : L
Atoms : A-Z (Except T and L)
Brackets: ()
Or: |
And: &
Implies: >
Not: ~
Turnstile: |-
Comma: ,

Please note: the system does not recognize operator precedence, please parenthesize accordingly.

Example:
java Main "((A>L)>A)>A"

Some tested formulae (some do not hold, included for demonstration):
"(A),(~B&C)|-~B"
"~(B&C)|-~B|~C"
"A|-~A"                         -Unsatisfiable
"(A|~A)|-(A&~A)"                -Unsatisfiable
"(A>B)|-~A|B"
"~~A|-A"
"L|-A"
"(((B&A)&C)>A)"
"((A&B)>A)"
"(A>A)"
"(A)|-(A)"
"(A&(B|C))>((A&B)|(A&C))"