def solution(participant, completion):
    for i in participant:
        for j in completion:
            if i == j :
                participant.pop(participant.index('i'))
                completion.pop(completion.index('j'))
            else :
                pass
        return participant[0]
    answer = participant[0]
    return answer
participant = ["leo", "kiki", "eden"]	
completion = ["eden", "kiki"]	
solution(participant, completion)
