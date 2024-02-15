import { useState } from "react";

export default function FormTezz() {
    
    const [answer, setAnswer] = useState('');
    const [error, setError] = useState(null);
    const [status, setStatus] = useState('typing');

    if (status === 'success') {
        return <h1>答对了！</h1>
    }

    async function handleSubmit(event) {
        event.preventDefault();
        setStatus('submitting');
        try {
            await submitForm(answer);
            setStatus('success');
        } catch (error) {
            setStatus('typing');
            setError(error);
        }
    }

    return (
        <>
            <div className="w-1/3 p-2 shadow overflow-y-auto h-96">
                <h2 className=" font-bold text-lg">城市测验</h2>
                <h2 className=" font-bold">哪个城市有把空气变成饮用水的广告牌？</h2>
                <form onSubmit={handleSubmit}>
                    <textarea value={answer} cols={50} rows={5} className="border-2 border-blue-800" 
                              onChange={ e => setAnswer(e.target.value)}
                              disabled={status === 'submitting'}></textarea>
                    <button className="btn-primary disabled:bg-gray-600" disabled={answer =='' || status == 'submitting'}>提交</button>
                </form>
                { error !=null && <p className=" text-red-500">{error.message}</p>}
            </div>
        </>
    )
}

function submitForm(answer) {
    return new Promise((resolve,reject)=> {
        setTimeout(() => {
            if(answer == 'taipei') {
                resolve('YES');
            } else {
                reject(new Error('猜的不错，但答案不对。再试试看吧！'));
            }
        }, 2000);
    });
}