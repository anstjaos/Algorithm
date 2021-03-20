#include <iostream>

int G, arrSize, l, r, sum;

int main()
{
	scanf("%d", &G);
	l = r = 1;
	while (l <= r)
	{
		int val = r * r - l * l;
		if (l + 1 == r && G < val) break;
		if (G <= val) l++;
		else r++;
		if (val == G) {
			printf("%d\n", r);
			arrSize++;
		}
	}


	if (arrSize == 0) printf("-1\n");

	return 0;
}