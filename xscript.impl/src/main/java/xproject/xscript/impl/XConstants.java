package xproject.xscript.impl;

public interface XConstants 
{
	static final String THIS = "this";
	static final String NULL = "null";
	static final String CLASS = "class";
	static final String RETURN = "return";
	static final String PARAMETER_NAME_PREFIX = "-";
	static final String OBJECT_REF_PREFIX = "#";
	static final String X_METHOD_NAME_PREFIX = "x";
	static final String PARAMETER_SEPARATOR = "\t";
	static final String CLASS_REF_PREFIX = "@";
	
	static final String IMPORT = "import";
	static final String NEW = "new";
	static final String TRY = "try";
	static final String CATCH = "catch";
	static final String THROW = "throw";
	static final String IF = "if";
	static final String ELSE = "else";
	static final String SUPER = "super";
	static final String DO = "do";
	static final String WHILE = "while";
	static final String BREAK = "break";
	static final String FOR = "for";
	static final String GOTO = "goto";
	static final String CONTINUE = "continue";
	static final String FINAL = "final";
	static final String FINALLY = "finally";
	static final String SYNCHRONIZED = "synchronized";
	static final String COMMENT_LINE = "//";
	static final String COMMENT_BLOCK = "/*";
	static final String COMMENT_BLOCK_END = "*/";
	
	static final String EXECUTOR = "exec";
	static final String EXECUTOR_AWAIT_TERMINATION = "awaitTermination";
	static final String EXECUTOR_SHUTDOWN = "shutdown";
	static final String EXECUTOR_SUBMIT = "submit";
	static final String EXECUTOR_IS_TERMINATED = "isTerminated";
	static final String EXECUTOR_EXECUTE = "execute";
	static final String EXECUTOR_SHUTDOWN_NOW = "shutdownNow";
	static final String EXECUTOR_INVOKE_ALL = "invokeAll";
	static final String EXECUTOR_INVOKE_ANY = "invokeAny";
	
	static final String EVAL = "eval";
	static final String HELP = "help";
	
	static final String AND = "and";
	static final String OR = "or";
	static final String NOT = "not";
	static final String TRUE = "true";
	static final String FALSE = "false";
	
	static final String DEBUG = "debug";
	static final String DEBUG_RUN = "run";
	static final String DEBUG_CONT = "cont";
	static final String DEBUG_PRINT = "print";
	static final String DEBUG_DUMP = "dump";
	static final String DEBUG_STOP = "stop";
	static final String DEBUG_CLEAR = "clear";
	static final String DEBUG_STEPP = "step";
	static final String DEBUG_NEXT = "next";
	static final String DEBUG_CATCH = "catch";
	static final String DEBUG_IGNORE = "ignore";
	
	static final String HELP_METHOD = "method";
	
	static final String LOG = "log";
	static final String LOG_CONFIG = "config";
	static final String LOG_FINE = "fine";
	static final String LOG_FINER = "finer";
	static final String LOG_FINEST = "finest";
	static final String LOG_INFO = "info";
	static final String LOG_SEVERE = "severe";
	static final String LOG_WARNING = "warning";
	
	static final String LAMBDA = "->";
	static final String ASSERT = "assert";
	
	static final String TEST = "test";
}
