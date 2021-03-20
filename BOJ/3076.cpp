#include <iostream>
using namespace std;

int R, C, A, B;
bool black = true;
bool startBlack = true;

int main()
{
	cin >> R >> C >> A >> B;
	for (int i = 0; i < R* A; i++)
	{
		for (int j = 0; j < C * B; j++)
		{
			if (black == true) printf("X");
			else printf(".");

			if ((j + 1) % B == 0) black = black * -1 + 1;
		}
		printf("\n");
		if ((i + 1) % A == 0)
		{
			startBlack = startBlack * -1 + 1;
		}
		black = startBlack;
	}
	printf("\n");
	return 0;
}