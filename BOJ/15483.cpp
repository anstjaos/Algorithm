#include <stdio.h>

char A[1005], B[1005];
int dist[1005][1005], Alen, Blen;

int min(int a, int b) { return (a < b ? a : b); }

int main()
{
	scanf("%s %s", A, B);
	while (A[Alen] != '\0')
	{
		dist[Alen + 1][0] = Alen + 1;
		Alen++;
	}

	while (B[Blen] != '\0') {
		dist[0][Blen + 1] = Blen + 1;
		Blen++;
	}

	for (register int i = 1; i <= Alen; i++) {
		for (register int j = 1; j <= Blen; j++) {
			if (A[i - 1] == B[j - 1]) dist[i][j] = dist[i - 1][j - 1];
			else {
				dist[i][j] = min(dist[i - 1][j - 1], min(dist[i - 1][j], dist[i][j - 1])) + 1;
			}
		}
	}

	printf("%d\n", dist[Alen][Blen]);
	return 0;
}