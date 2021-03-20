#include <stdio.h>

char input[104];
double stack[105];
int top = -1, arr[30], N;

//////////////////////////////////
void push(double item)
{
	stack[++top] = item;
}

double pop()
{
	return stack[top--];
}

double getTop()
{
	return stack[top];
}

void calculate(const char oper)
{
	double num1 = pop();
	double num2 = pop();

	double ret = 0;
	switch (oper)
	{
	case '+':
		ret = num2 + num1;
		break;
	case '-':
		ret = num2 - num1;
		break;
	case '*':
		ret = num2 * num1;
		break;
	case '/':
		ret = num2 /num1;
		break;
	}
	push(ret);
}

int main()
{
	scanf("%d %s", &N, input);

	for (register int i = 0; i < N; i++) scanf("%d", arr + i);

	int idx = 0;
	while (input[idx] != 0)
	{
		if ('A' <= input[idx] && input[idx] <= 'Z') {
			push((double)arr[input[idx] - 'A']);
			idx++;
			continue;
		}

		calculate(input[idx]);
		
		idx++;
	}
	
	double res = getTop();
	printf("%.2f\n", res);
	
	return 0;
}