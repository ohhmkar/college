```C
int factorial(int n) {  
    if (n \== 0\) return 1;  
    return n \* factorial(n \- 1);  
}

int fibonacci(int n) {  
    if (n \<= 1\) return n;  
    return fibonacci(n \- 1\) \+ fibonacci(n \- 2);  
}

int sumArray(int arr\[\], int n) {  
    if (n \== 0\) return 0;  
    return arr\[n \- 1\] \+ sumArray(arr, n \- 1);  
}

int maxArray(int arr\[\], int n) {  
    if (n \== 1\) return arr\[0\];

    int maxNo \= maxArray(arr, n \- 1);  
    return (arr\[n \- 1\] \> maxNo) ? arr\[n \- 1\] : maxNo;  
}

void reverseString(char str\[\], int start, int end) {  
    if (start \>= end) return;

    char temp \= str\[start\];  
    str\[start\] \= str\[end\];  
    str\[end\] \= temp;

    reverseString(str, start \+ 1, end \- 1);  
}

int isPalindrome(char str\[\], int start, int end) {  
    if (start \>= end) return 1;  
    if (str\[start\] \!= str\[end\]) return 0;

    return isPalindrome(str, start \+ 1, end \- 1);  
}

int power(int base, int exp) {  
    if (exp \== 0\) return 1;  
    return base \* power(base, exp \- 1);  
}

int binarySearch(int arr\[\], int low, int high, int key) {  
    if (low \> high) return \-1;

    int mid \= (low \+ high) / 2;

    if (arr\[mid\] \== key) return mid;  
    else if (key \< arr\[mid\])  
        return binarySearch(arr, low, mid \- 1, key);  
    else  
        return binarySearch(arr, mid \+ 1, high, key);  
}

int isVowel(char c) {  
    c \= tolower(c);  
    return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');  
}

int countVowels(char str\[\], int index) {  
    if (str\[index\] \== '\\0') return 0;

    return isVowel(str\[index\]) \+ countVowels(str, index \+ 1);  
}

void towerOfHanoi(int n, char from, char to, char aux) {  
    if (n \== 1\) {  
        printf("Move disk 1 from %c → %c\\n", from, to);  
        return;  
    }

    towerOfHanoi(n \- 1, from, aux, to);  
    printf("Move disk %d from %c → %c\\n", n, from, to);  
    towerOfHanoi(n \- 1, aux, to, from);  
}  
```
