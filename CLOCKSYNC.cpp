#include <iostream>
using namespace std;

#define INF 2123456789

int tc, clockC[16], result;
char clockSwitch[10][17] = {
	"xxx.............",
	"...x...x.x.x....",
	"....x.....x...xx",
	"x...xxxx........",
	"......xxx.x.x...",
	"x.x...........xx",
	"...x..........xx",
	"....xx.x......xx",
	".xxxxx..........",
	"...xxx...x...x.."
};

int min(int a, int b) { return (a < b ? a : b); }

void push(int sc)
{
	for (register int i = 0; i < 16; i++) {
		if (clockSwitch[sc][i] == 'x') {
			clockC[i] += 3;
			if (clockC[i] == 15) clockC[i] = 3;
		}
	}
}

bool isAllTwelve() {
	for (register int i = 0; i < 16; i++) {
		if (clockC[i] != 12) return false;
	}
	return true;
}

int solve(int switchCnt)
{
	if (switchCnt == 10) {
		return isAllTwelve() ? 0 : INF;
	}

	int ret = INF;
	for (register int i = 0; i < 4; i++) {
		ret = min(ret, i + solve(switchCnt + 1));
		push(switchCnt);
	}
	return ret;
}

int main()
{
	scanf("%d", &tc);
	while (tc--)
	{
		for (register int i = 0; i < 16; i++) scanf("%d", clockC + i);
		result = solve(0);
		result == INF ? printf("-1\n") : printf("%d\n", result);
	}
}