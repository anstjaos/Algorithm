#include <iostream>
#include <math.h>
#include <algorithm>
#include <set>
using namespace std;

typedef struct a{
	int x;
	int y;
	a() {}
	a(int i_x, int i_y) {
		x = i_x;
		y = i_y;
	}
	bool operator < (const a &v) const {
		if (y == v.y) {
			return x < v.x;
		}
		else {
			return y < v.y;
		}
	}
}Point;

int N;
Point pointArr[100001];

bool cmp(const Point &a, const Point &b) { return a.x < b.x; }
int dist(Point a, Point b) {
	return (b.x - a.x) * (b.x - a.x) + (b.y - a.y) *(b.y - a.y);
}

int main()
{
	scanf("%d", &N);
	for (register int i = 0; i < N; i++)
	{
		scanf("%d %d", &pointArr[i].x, &pointArr[i].y);
	}
	sort(pointArr, pointArr + N, cmp);

	set<Point> candidate = { pointArr[0], pointArr[1] };

	int start = 0;
	int ans = dist(pointArr[0], pointArr[1]);
	for (register int i = 2; i < N; i++)
	{
		Point cur = pointArr[i];
		while (start < i)
		{
			Point p = pointArr[start];
			int x = cur.x - p.x;
			if (x * x > ans)
			{
				candidate.erase(p);
				start++;
			}
			else break;
		}

		int d = (int)sqrt((double)ans) + 1;
		Point lower_point = Point(-100000, cur.y - d);
		Point upper_point = Point(100000, cur.y + d);

		auto lower = candidate.lower_bound(lower_point);
		auto upper = candidate.upper_bound(upper_point);

		for (auto it = lower; it != upper; it++)
		{
			int d = dist(cur, *it);
			if (d < ans) {
				ans = d;
			}
		}
		candidate.insert(cur);
	}

	printf("%d\n", ans);
	return 0;
}