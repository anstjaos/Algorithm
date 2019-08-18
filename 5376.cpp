#include <cstdio>
#include <cmath>

int tc, inputSize, num1, num2, num1Len, num2Len;
long long bot, top;
char input[20];

long long findGCD(long long a, long long b)
{
	long long c;
	while (b)
	{
		c = a % b;
		a = b;
		b = c;
	}
	return a;
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		inputSize = 0;
		scanf("%s", input);
		while (input[inputSize] != '\0') inputSize++;

		num1 = num2 = 0;
		num1Len = 0, num2Len = 0;

		bool flag = false;
		for (register int i = 2; i < inputSize; i++) {
			if (input[i] == '(') {
				flag = true;
				continue;
			}
			if (input[i] == ')') break;

			if (!flag) {
				num1 = num1 * 10 + (input[i] - '0');
				num1Len++;
			}
			else {
				num2 = num2 * 10 + (input[i] - '0');
				num2Len++;
			}
		}

		bot = top = 1;
		if (num1Len == 0 && num2Len == 0) {
			printf("0\n");
			continue;
		}
		
		if (num1Len == 0) {
			top = num2;
			bot = (long long)pow(10, num2Len) - 1;
		}
		else if (num2Len == 0) {
			top = num1;
			bot = (long long)pow(10, num1Len);
		}
		else {
			top = (long long)pow(10, num2Len) * num1 + num2 - num1;
			bot = ((long long)pow(10, num2Len) - 1) * (long long)pow(10, num1Len);
		}
	
		long long gcd = findGCD(bot, top);
		printf("%lld/%lld\n", top / gcd, bot / gcd);
	}
	return 0;
}