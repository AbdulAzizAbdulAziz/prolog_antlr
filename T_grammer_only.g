grammar T_grammer_only;

prog : statementlist
     ;

statementlist:statement (statement)*;

statement:facts|queries;

facts :s1=ID'('s2=ID(',' s3=ID)*')''.';

queries :'?-'s1=ID'('s2=(ID|Var)(',' s3=(ID|Var))*')''.';

Int :'0'..'9'('0'..'9')*;

ID : ('a'..'z')(Int|('a'..'z'))*;

Var : ('A'..'Z')(Int|('a'..'z'| 'A'..'Z'))*;

WS : (' '|'\t'|'\n'|'\r')+ {skip();};