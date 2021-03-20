#include <stdio.h>

int N, M, check[51][4], result, maxNum, maxIndex;
char input[1001][51], resultStr[51];

int main()
{
	scanf("%d %d", &N, &M);
	for (register int i = 0; i < N; i++) {
		scanf("%s", input[i]);
		for (register int j = 0; j < M; j++) {
			if (input[i][j] == 'A') check[j][0]++;
			else if (input[i][j] == 'C') check[j][1]++;
			else if (input[i][j] == 'G') check[j][2]++;
			else if (input[i][j] == 'T') check[j][3]++;
		}
	}

	for (register int i = 0; i < M; i++) {
		maxNum = 0;
		maxIndex = 0;
		for (register int j = 0; j < 4; j++) {
			if (check[i][j] > maxNum) {
				maxNum = check[i][j];
				maxIndex = j;
			}
		}
		result += (N - maxNum);

		switch (maxIndex) {
		case 0:
			resultStr[i] = 'A';
			break;
		case 1:
			resultStr[i] = 'C';
			break;
		case 2:
			resultStr[i] = 'G';
			break;
		case 3:
			resultStr[i] = 'T';
			break;
		}
	}

	printf("%s\n%d\n", resultStr, result);
	return 0;
}