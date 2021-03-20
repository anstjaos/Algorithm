#include <stdio.h>

int stack[10005], top = -1, N;
char input[10];

bool strCmp(const char *s, const char* s1)
{
	int idx = 0;
	while (s[idx] == s1[idx]) {
		if (s[idx] == '\0') break;
		idx++;
	}

	if (s[idx] == '\0' && s1[idx] == '\0') return true;
	return false;
}

void push(int item)
{
	stack[++top] = item;
}

int pop()
{
	return stack[top--];
}

bool isEmpty()
{
	return top == -1;
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		scanf("%s", input);

		if (strCmp(input, "push")) {
			int num;
			scanf("%d", &num);
			push(num);
		}
		else if (strCmp(input, "pop")) {
			if (isEmpty()) printf("-1\n");
			else printf("%d\n", pop());
		}
		else if (strCmp(input, "empty")) {
			isEmpty() == true ? printf("1\n") : printf("0\n");
		}
		else if (strCmp(input, "size")) {
			printf("%d\n", top + 1);
		}
		else if (strCmp(input, "top")) {
			if (isEmpty()) printf("-1\n");
			printf("%d\n", stack[top]);
		}
	}
	return 0;
}