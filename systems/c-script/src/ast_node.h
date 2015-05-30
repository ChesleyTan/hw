typedef enum {
    typeConst,
    typeId,
    typeOper
} nodeTypeEnum;

typedef struct {
    int value;
} constNodeType;

typedef struct {
    char *varName;
} idNodeType;

typedef struct {
    int oper;
    int numOperands;
    struct nodeTypeTag **operands;
} operNodeType;

typdef struct nodeTypeTag {
    nodeTypeEnum type;
    union {
        constNodeType con;
        idNodeType id;
        operNodeType oper;
    }
} nodeType;

extern hash_table *sym;
