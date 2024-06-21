// https://leetcode.com/problems/reverse-prefix-of-word

char* reversePrefix(char* word, char ch) {
    short i = 0;
    while (*((char*) (word + i)) != 0 && *((char*) (word + i)) != ch) {
        i++;
    }
    // printf("i: %d\n", i);
    if (*((char*) (word + i)) != 0) {
        reverse(word, i);  
    }
    return word;
}

void reverse(char* word, short i) { // 2 chars = 1; 3 chars = 2; 4 chars = 3;
    while (i > 0) {
        // printf("i: %d\n", i);
        // printf("init word: %s\n", word);
        char b = *word;
        *word = *((char*) (word + i));
        *((char*) (word + i)) = b;
        // printf("after word: %s\n", word);
        word++;
        i -= 2;
    }
}