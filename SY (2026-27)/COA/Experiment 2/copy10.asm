; Write a program to copy 10 words ( 16 bit numbers) from memory location 1000:0000 to 2000:0000
STACK SEGMENT STACK
        DW 16 DUP(0)
STACK ENDS

DATA SEGMENT
        ORG 0000H
        INPUT_DATA DW 1234h, 5678h, 09ABCh, 0DEF0h, 1111h
                   DW 2222h, 3333h, 4444h, 5555h, 6666h
DATA ENDS

CODE SEGMENT
        ASSUME CS: CODE, DS:DATA, ES:DATA
START:
        ; Source init
        MOV AX, 1000H 
        MOV DS, AX 
        MOV SI, 0000H
        
        ; Destination init
        MOV AX, 2000H 
        MOV ES, AX
    MOV DI, 0000H
    
    MOV CX, 000AH
    CLD 
CL_LOOP:
        MOVSW
        LOOP CL_LOOP 

        MOV AH, 4CH
        INT 21H
CODE ENDS
END START

