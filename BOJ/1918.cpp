#include <stdio.h>

typedef struct {
	char oper;
	int rank;
}Operator;

char input[104];
Operator stack[105];
int top = -1;

void push(Operator item)
{
	stack[++top] = item;
}

Operator pop()
{
	return stack[top--];
}

Operator getTop()
{
	return stack[top];
}

bool isEmpty()
{
	return top == -1;
}

int main()
{
	scanf("%s", input);

	int idx = 0;
	while (input[idx] != 0)
	{
		if ('A' <= input[idx] && input[idx] <= 'Z') {
			printf("%c", input[idx]);
			idx++;
			continue;
		}
		
		if (input[idx] == ')') {
			while (1)
			{
				Operator c = pop();
				if (c.oper == '(') break;
				printf("%c", c.oper);
			}
			idx++;
			continue;
		}

		Operator temp;
		temp.oper = input[idx];
		switch (input[idx]) {
		case '(':
			temp.rank = 0;
			break;
		case '+':
		case '-':
			temp.rank = 1;
			break;
		case '*':
		case '/':
			temp.rank = 2;
			break;
		}

		if (temp.oper == '(') {
			push(temp);
			idx++;
			continue;
		}
		while (!isEmpty())
		{
			Operator oper = getTop();
			if (oper.rank < temp.rank) break;
			printf("%c", oper.oper);
			pop();
		}

		push(temp);
		idx++;
	}
	while (!isEmpty())
	{
		printf("%c", pop().oper);
	}
	printf("\n");
	return 0;
}