#include <stdio.h>

int N, top = -1;
char input[100];
char stack[100];

void push(char item) {
	stack[++top] = item;
}

char pop()
{
	return stack[top--];
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++) {
		top = -1;
		scanf("%s", input);
		
		int idx = 0;
		bool flag = true;
		while (input[idx] != '\0') {
			if (input[idx] == '(') push('(');
			else if (input[idx] == ')') {
				if (top == -1) {
					flag = false;
					break;
				}
				pop();
			}

			idx++;
		}

		if (!flag) printf("NO\n");

		if (top != -1) printf("NO\n");
		else printf("YES\n");
	}

	return 0;
}