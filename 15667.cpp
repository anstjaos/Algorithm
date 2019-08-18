#include <iostream>
using namespace std;

int K;

int main()
{
	cin >> K;

	for (int i = 1; i <= 100; i++)
	{
		if (i * (i + 1) + 1 == K)
		{
			cout << i << endl;
			break;
		}
	}

	return 0;
}