#include <iostream>
using namespace std;

typedef struct Ranking {
	int score;
	int rank;
	Ranking *next;
	Ranking() {}
	Ranking(int i_score, int i_rank)
	{
		score = i_score;
		rank = i_rank;
		next = NULL;
	}
}Ranking;

Ranking *start;
int N, sco, P;
int input, result, beforeScore, beforeRank;

void deleteRanking()
{
	Ranking *ptr = start;
	while (ptr != NULL)
	{
		Ranking *temp = ptr;
		ptr = ptr->next;
		delete temp;
	}
}

int main()
{
	cin >> N >> sco >> P;
	start = new Ranking(0, 0);
	Ranking *ptr = start;
	for (int i = 1; i <= N; i++)
	{
		cin >> input;
		if (i <= P)
		{
			if (beforeScore != input)
			{
				ptr->next = new Ranking(input, i);
				beforeScore = input;
				beforeRank = i;
			}
			else
			{
				ptr->next = new Ranking(input, beforeRank);
			}
			ptr = ptr->next;
		}
	}

	ptr = start->next;
	Ranking *before = start;
	result = -1;
	while (ptr != NULL)
	{
		if (ptr->score < sco)
		{
			if (before->score == sco)
			{
				result = before->rank;
			}
			else
			{
				result = ptr->rank - 1;
				if (result == 0) result = 1;
			}
			break;
		}

		before = ptr;
		ptr = ptr->next;
	}

	if (result == -1 && N < P)
	{
		if (before->score == sco)
		{
			result = before->rank;
			if (before->rank == 0) result = 1;
		}
		else result = before->rank + 1;
	}
	cout << result << endl;
	deleteRanking();
	return 0;
}