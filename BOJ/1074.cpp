#include <iostream>

using namespace std;



int N, R, C;

int cnt;



void Z(int size, int y, int x)

{

	//제일 작은 크기, 2 == (1 << 1)

	if (size == 2)

	{

		if (y == R && x == C)

		{

			cout << cnt << "\n";

			return;

		}

		cnt++;

		if (y == R && x + 1 == C)

		{

			cout << cnt << "\n";

			return;

		}

		cnt++;

		if (y + 1 == R && x == C)

		{

			cout << cnt << "\n";

			return;

		}

		cnt++;

		if (y + 1 == R && x + 1 == C)

		{

			cout << cnt << "\n";

			return;

		}

		cnt++;

		return; //해당 2 * 2 블럭에 R, C가 없을 경우

	}

	//1사분면

	Z(size / 2, y, x);

	//2사분면

	Z(size / 2, y, x + size / 2);

	//3사분면

	Z(size / 2, y + size / 2, x);

	//4사분면

	Z(size / 2, y + size / 2, x + size / 2);

}



int main(void)

{

	cin >> N >> R >> C;



	Z(1 << N, 0, 0);

	return 0;

}