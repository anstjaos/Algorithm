#include <stdio.h>
#define MAX_SIZE 500005

char input[MAX_SIZE];
int len, gp[MAX_SIZE], ngp[MAX_SIZE], sfx[MAX_SIZE], cnt[MAX_SIZE], aux[MAX_SIZE];
int rank[MAX_SIZE], lcp[MAX_SIZE];

int min(int a, int b) { return (a < b ? a : b); }
int max(int a, int b) { return (a > b ? a : b); }
void getSfx()
{
	for (register int i = 0; i < len; i++) {
		sfx[i] = i;
		gp[i] = input[i];
	}
	int pnt = 1;
	for (register int p = 1; p < len; p <<= 1) {
		for (register int i = 0; i < MAX_SIZE; i++) cnt[i] = 0;
		for (register int i = 0; i < len; i++) cnt[gp[min(i + p, len)]]++;
		for (register int i = 1; i <= len || i <= 256; i++) cnt[i] += cnt[i - 1];
		for (register int i = len - 1; i >= 0; i--) aux[--cnt[gp[min(i + p, len)]]] = i;

		for (register int i = 0; i < MAX_SIZE; i++) cnt[i] = 0;
		for (register int i = 0; i < len; i++) cnt[gp[i]]++;
		for (register int i = 1; i <= len || i <= 256; i++) cnt[i] += cnt[i - 1];
		for (register int i = len - 1; i >= 0; i--) sfx[--cnt[gp[aux[i]]]] = aux[i];

		if (pnt == len) break;
		pnt = 1;
		ngp[sfx[0]] = 1;

		for (register int i = 1; i < len; i++) {
			if (gp[sfx[i]] != gp[sfx[i - 1]] || gp[sfx[i] + p] != gp[sfx[i - 1] + p]) pnt++;
			ngp[sfx[i]] = pnt;
		}

		for (register int i = 0; i < len; i++) gp[i] = ngp[i];
	}
	//for (register int i = 0; i < len; i++) sfx[i]++;
}

void getLcp()
{
	for (register int i = 0; i < len; i++) rank[sfx[i]] = i;
	int h = 0;
	for (register int i = 0; i < len; i++) {
		if (rank[i]) {
			int pre = sfx[rank[i] - 1];
			while (input[i + h] == input[pre + h]) h++;

			lcp[rank[i]] = h;
		}
		h = max(h - 1, 0);
	}
}
int main()
{
	scanf("%s", input);
	while (input[len] != '\0') len++;

	getSfx();
	getLcp();

	for (register int i = 0; i < len; i++) printf("%d ", sfx[i]+1);
	printf("\nx ");
	for (register int i = 1; i < len; i++) printf("%d ", lcp[i]);
	printf("\n");
	return 0;
}