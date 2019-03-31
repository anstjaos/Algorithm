#include <iostream>
using namespace std;

int N;
char arr[65][65];

void solve(int x, int y, int size)
{
	if (size == 1) {
		printf("%c",arr[x][y]);
		return;
	}

	char num = arr[x][y];
	bool allSame = true;
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			if (arr[x + i][y + j] != num) {
				allSame = false;
				break;
			}
		}
		if (!allSame) break;
	}

	if (allSame) {
		printf("%c", num);
		return;
	}

	printf("(");
	solve(x, y, size / 2);
	solve(x, y + (size / 2), size / 2);
	solve(x + (size / 2), y, size / 2);
	solve(x + (size / 2), y + (size / 2), size / 2);
	printf(")");
}

int main()
{
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%s", arr + i);
	}

	solve(0,0, N);
	return 0;
}