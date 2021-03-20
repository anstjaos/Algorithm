#include <iostream>
using namespace std;
int testCase;

int xa, ya, ra;
int xb, yb, rb;

double root(double num)
{
	double next;
	double temp;

	next = (1 + (num / 1)) / 2;

	while (1)
	{
		temp = next;
		next = (next + (num / next)) / 2;

		if (temp - next < 0.005 || temp - next < -0.005) break;
	}
	return next;
}

int main()
{
	scanf("%d", &testCase);
	for (int i = 0; i < testCase; i++)
	{


		scanf("%d %d %d %d %d %d", &xa, &ya, &ra, &xb, &yb, &rb);
		int distance = root(((xa - xb) * (xa - xb)) + ((ya - yb) * (ya - yb)));

		if (xa == xb && ya == yb)
		{
			if (ra == rb) printf("-1\n");
			else printf("0\n");
		}
		else if (abs(ra - rb) < distance && distance < (ra + rb)) printf("2\n");
		else if ((ra + rb) == distance) printf("1\n");
		else if ((ra + rb) < distance) printf("0\n");
	}
}