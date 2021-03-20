#include <cstdio>

int x, y, x1, y1, x2, y2;

int cross(int aX, int aY, int bX, int bY)
{
	return (aX*bY - bX * aY);
}

int main()
{
	scanf("%d %d %d %d %d %d", &x, &y, &x1, &y1, &x2, &y2);
	int res = cross(x1 - x, y1 - y, x2 - x, y2 - y);

	if (res > 0) printf("1\n");
	else if (res < 0) printf("-1\n");
	else printf("0\n");
	return 0;
}