#include <iostream>

using namespace std;



int N, R, C;

int cnt;



void Z(int size, int y, int x)

{

	//���� ���� ũ��, 2 == (1 << 1)

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

		return; //�ش� 2 * 2 ���� R, C�� ���� ���

	}

	//1��и�

	Z(size / 2, y, x);

	//2��и�

	Z(size / 2, y, x + size / 2);

	//3��и�

	Z(size / 2, y + size / 2, x);

	//4��и�

	Z(size / 2, y + size / 2, x + size / 2);

}



int main(void)

{

	cin >> N >> R >> C;



	Z(1 << N, 0, 0);

	return 0;

}