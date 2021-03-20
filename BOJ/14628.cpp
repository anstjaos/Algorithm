#include <iostream>
using namespace std;

typedef struct {
	int damage, mp;
}skill;

skill skillArr[101];
int N, M, K;
int minMp = 2123456789;

void solve(int health, int mp)
{
	if (health < 0) return;

	if (health == 0)
	{
		if (mp < minMp) minMp = mp;
		return;
	}

	for (int i = 0; i < 3; i++)
	{
		skillArr[i].mp += K;
		solve(health - skillArr[i].damage, mp + skillArr[i].mp - K);
		skillArr[i].mp -= K;
	}
}

int main()
{
	cin >> N >> M >> K;

	for (int i = 0; i < N; i++)
	{
		cin >> skillArr[i].mp >> skillArr[i].damage;
	}

	solve(M, 0);
	cout << minMp << '\n';
	return 0;
}