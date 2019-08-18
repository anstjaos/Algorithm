#include <stdio.h>

#define MAX_LEN 400001

char input[MAX_LEN];
int len, sfx[MAX_LEN], g[MAX_LEN], ng[MAX_LEN], aux[MAX_LEN], rank[MAX_LEN], lcp[MAX_LEN],  cnt[MAX_LEN],result;

int max(int a, int b) { return (a > b ? a : b); }
int min(int a, int b) { return (a < b ? a : b); }

void getSfx()
{
	
	for (register int i = 0; i < len; i++)
	{
		sfx[i] = i;
		g[i] = input[i];
	}
	int h = 1;
	for (register int p = 1; p < len; p <<= 1)
	{
		for (register int i = 0; i < MAX_LEN; i++) cnt[i] = 0;
		
		for (register int i = 0; i < len; i++) cnt[g[min(i + p, len)]]++;
		for (register int i = 1; i < MAX_LEN; i++) cnt[i] += cnt[i - 1];
		for (register int i = len - 1; i >= 0; i--) aux[--cnt[g[min(i + p, len)]]] = i;

		for (register int i = 0; i < MAX_LEN; i++) cnt[i] = 0;

		for (register int i = 0; i < len; i++) cnt[g[i]]++;
		for (register int i = 1; i < MAX_LEN; i++) cnt[i] += cnt[i - 1];
		for (register int i = len - 1; i >= 0; i--) sfx[--cnt[g[aux[i]]]] = aux[i];

		if (h == len) break;
		h = 1;
		ng[sfx[0]] = 1;
		for (register int i = 1; i < len; i++)
		{
			if (g[sfx[i - 1]] != g[sfx[i]] || g[sfx[i - 1] + p] != g[sfx[i] + p]) {
				h++;
			}
			ng[sfx[i]] = h;
		}

		for (register int i = 0; i < len; i++) g[i] = ng[i];
	}
}

void getLcp()
{
	for (register int i = 0; i < len; i++) rank[sfx[i]] = i;
	int h = 0;
	for (register int i = 0; i < len; i++) {
		if (rank[i]) {
			int pre = sfx[rank[i] -1];
			while (input[i + h] == input[pre + h]) h++;
			lcp[rank[i]] = h;
			result = max(result, lcp[rank[i]]);
		}
		h = max(h - 1, 0);
	}
}

int main()
{
	scanf("%d %s", &len, input);
	getSfx();
	getLcp();
	printf("%d\n", result);
	return 0;
}