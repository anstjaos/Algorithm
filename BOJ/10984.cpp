#include <cstdio>
#include <cmath>

int T, N, gradeSum, grade;
float scoreSum, score;

int main()
{
	scanf("%d", &T);
	while (T--)
	{
		scoreSum = 0.0;
		gradeSum = 0;
		scanf("%d", &N);
		
		for (register int i = 0; i < N; i++) {
			scanf("%d %f", &grade, &score);
			gradeSum += grade;
			scoreSum += score * grade;
		}
		scoreSum = scoreSum / gradeSum * 10;
		scoreSum = round(scoreSum);
		printf("%d %.1f\n", gradeSum, scoreSum / 10);
	}
	return 0;
}