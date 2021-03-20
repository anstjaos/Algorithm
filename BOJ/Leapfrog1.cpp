#include <cstdio>

int T, dotCnt, bCnt;
char input[5006];

int main()
{
	scanf("%d", &T);
	for (register int t = 1; t <= T; t++)
	{
		scanf("%s", input);
		dotCnt = bCnt = 0;
		int idx = 0;
		while (input[idx] != '\0')
		{
			if (input[idx] == 'B') bCnt++;
			else if (input[idx] == '.') dotCnt++;
			idx++;
		}

		printf("Case #%d: ", t);
		if (dotCnt > 0 && bCnt >= dotCnt) printf("Y\n");
		else printf("N\n");
	}

	return 0;
}