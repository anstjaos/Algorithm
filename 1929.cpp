#include <iostream>
using namespace std;

#define MAX_NUM 1000001
int M, N;
bool prime[MAX_NUM];

void init()
{
	for (register int i = 2; i < MAX_NUM; i++) {
		prime[i] = true;
	}

	for (register int i = 2; i * i < MAX_NUM; i++) {
		if (prime[i] == true) {
			for (register int j = i * i; j < MAX_NUM; j += i) {
				prime[j] = false;
			}
		}
	}
}

int main()
{
	init();
	scanf("%d %d", &M, &N);

	for (register int i = M; i <= N; i++) {
		if (prime[i] == true) {
			printf("%d\n", i);
		}
	}
	return 0;
}