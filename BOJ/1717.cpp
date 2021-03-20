#include <iostream>
using namespace std;

int arrSet[1000001], n, m, input, a, b;


int findSet(int a)
{
	if (arrSet[a] == a) return a;
	
	return arrSet[a] = findSet(arrSet[a]);
}

void makeSet(int a, int b)
{
	int parentA = findSet(a);
	int parentB = findSet(b);

	if (parentA != parentB) arrSet[parentA] = parentB;

}

int main()
{
	scanf("%d %d ", &n, &m);

	for (int i = 0; i <= n; i++) arrSet[i] = i;

	for (int i = 0; i < m; i++)
	{
		scanf("%d %d %d ", &input, &a, &b);

		if (input == 0) makeSet(a, b);
		else if (input == 1)
		{
			int resultA = findSet(a);
			int resultB = findSet(b);

			if (resultA == resultB) printf("YES\n");
			else printf("NO\n");
		}
	}

	return 0;
}