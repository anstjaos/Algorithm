#include <cstdio>
#define _USE_MATH_DEFINES
#include <cmath>
#define MAX_SIZE 1005

typedef struct {
	int lx;
	int rx;
	int h;
}Struc;

Struc strucArr[MAX_SIZE];
int R, sx, ex, N;
double answer;

int main()
{
	int testCase;
	scanf("%d", &testCase);
	for (register int t = 1; t <= testCase; t++)
	{
		scanf("%d %d %d %d", &R, &sx, &ex, &N);
		answer = 0.0;
		for (register int i = 0; i < N; i++) {
			scanf("%d %d %d", &strucArr[i].lx, &strucArr[i].rx, &strucArr[i].h);
			answer += strucArr[i].rx - strucArr[i].lx; // 윗단 간격
			if (strucArr[i].h >= R) {
				answer += (strucArr[i].h - R) * 2; // 높이
			}
		}

		if(strucArr[0].h >= R) answer += (strucArr[0].lx - sx - R); // 처음 간격
		else {
			answer += (strucArr[0].lx - sx - sqrt(2 * R * strucArr[0].h - (strucArr[0].h*strucArr[0].h)));
		}

		if(strucArr[N-1].h >= R) answer += (ex - strucArr[N - 1].rx - R); // 끝 간격
		else {
			answer += (ex - strucArr[N - 1].rx - sqrt(2 * R * strucArr[N-1].h - (strucArr[N-1].h*strucArr[N-1].h)));
		}

		for (register int i = 1; i < N; i++){
			if (strucArr[i].h < R && strucArr[i-1].h >= R) {
				answer += (strucArr[i].lx - strucArr[i - 1].rx - R - sqrt(2 * R * strucArr[i].h - (strucArr[i].h*strucArr[i].h)));
			}
			else if (strucArr[i - 1].h < R && strucArr[i].h >= R) {
				answer += (strucArr[i].lx - strucArr[i - 1].rx - R - sqrt(2 * R * strucArr[i-1].h - (strucArr[i-1].h*strucArr[i-1].h)));
			}
			else if (strucArr[i - 1].h < R && strucArr[i].h < R)
			{
				answer += (strucArr[i].lx - strucArr[i - 1].rx - sqrt(2 * R * strucArr[i].h - (strucArr[i].h*strucArr[i].h)) - sqrt(2 * R * strucArr[i - 1].h - (strucArr[i - 1].h*strucArr[i - 1].h)));
			}
			else answer += (strucArr[i].lx - strucArr[i-1].rx - (2 * R));
		}

		// 부채꼴
		for (register int i = 0; i < N; i++) {
			if (strucArr[i].h >= R){
				answer += (M_PI * R);
			}
			else {
				double angle = atan2(R - strucArr[i].h, sqrt(2*R*strucArr[i].h - (strucArr[i].h*strucArr[i].h))) * 180 / M_PI;
				answer += (2 * M_PI*R * (90-angle) / 360 * 2);
			}
		}
		printf("Case #%d\n%f\n", t, answer);
	}
	return 0;
}