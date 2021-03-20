#include <cstdio>
using namespace std;

int N, K, temp, top = -1;
char input[500001], stack[500001];

int main()
{
	scanf("%d %d %s", &N, &K, input);
	temp = K;
	for (register int i = 0; i < N; i++)
	{
		while (temp > 0 && top >= 0 && stack[top] < input[i]) {
			temp--;
			top--;
		}
		stack[++top] = input[i];
	}

	for (register int i = 0; i < N-K; i++) {
		printf("%c", stack[i]);
	}
	printf("\n");
	return 0;
}