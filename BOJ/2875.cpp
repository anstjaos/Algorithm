#include <cstdio>

int girlCnt, boyCnt, internCnt, teamCnt;

int main()
{
	scanf("%d %d %d", &girlCnt, &boyCnt, &internCnt);

	if (girlCnt >= 2 * boyCnt) teamCnt = boyCnt;
	else teamCnt = girlCnt / 2;

	girlCnt -= teamCnt * 2;
	boyCnt -= teamCnt;

	if (internCnt > 0 && girlCnt > 0) {
		internCnt -= girlCnt;
		girlCnt = 0;
	}
	if (internCnt > 0 && boyCnt > 0) {
		internCnt -= boyCnt;
		boyCnt = 0;
	}

	while (internCnt > 0)
	{
		teamCnt--;
		internCnt -= 3;
	}

	teamCnt <= 0 ? printf("0\n") : printf("%d\n", teamCnt);
	return 0; 
}