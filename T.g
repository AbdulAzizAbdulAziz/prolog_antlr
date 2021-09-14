grammar T;

@header {import java.util.Collection;import java.util.HashMap;}

@members{actions act=new actions();}

prog : statementlist
     ;

statementlist:statement (statement)*;

statement:facts|queries;

facts returns[ArrayList<String> a]@init {$a = new ArrayList<String>();}:s1=ID{act.gen_fax($s1.text);}'('s2=ID{a.add($s2.text);}(',' s3=ID {a.add($s3.text);})*')''.'{act.push_fax($s1.text,a);};

queries returns[ArrayList<String> a]@init {$a = new ArrayList<String>();}:'?-'s1=ID'('s2=(ID|Var){a.add($s2.text);}(',' s3=(ID|Var){a.add($s3.text);})*')''.'{act.quer($s1.text,a);};

Int :'0'..'9'('0'..'9')*;

ID : ('a'..'z')(Int|('a'..'z'))*;

Var : ('A'..'Z')(Int|('a'..'z'| 'A'..'Z'))*;

WS : (' '|'\t'|'\n'|'\r')+ {skip();};