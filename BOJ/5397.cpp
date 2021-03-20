#include <stdio.h>

typedef struct Stack{
	char stack[1000001];
	int top;

	Stack() { top = -1; }
	void push(int item)
	{
		stack[++top] = item;
	}

	bool isEmpty()
	{
		return top == -1;
	}

	char pop()
	{
		if (isEmpty()) return '\0';
		return stack[top--];
	}
}Stack;

int tc, len;
char input[1000001];
Stack s1, s2;

int strlen(const char *s)
{
	int idx = 0;
	while (s[idx] != 0) idx++;
	return idx;
}

void init()
{
	for (register int i = 0; i < len; i++) input[i] = '\0';
	scanf("%s", input);
	len = strlen(input);
	s1.top = -1;
	s2.top = -1;
}

int main()
{
	scanf("%d", &tc);
	for (register int t = 0; t < tc; t++)
	{
		init();
		
		for (register int i = 0; i < len; i++)
		{
			char c = input[i];
			char temp = 0;
			switch (c) {
			case '<':
				temp = s1.pop();
				if (temp == '\0') continue;
				s2.push(temp);
				break;
			case '>':
				temp = s2.pop();
				if (temp == '\0') continue;
				s1.push(temp);
				break;
			case '-':
				s1.pop();
				break;
			default:
				s1.push(c);
				break;
			}
		}

		while (!s1.isEmpty()) {
			char temp = s1.pop();
			s2.push(temp);
		}

		while (!s2.isEmpty()) printf("%c", s2.pop());
		printf("\n");
	}

	return 0;
}