import React, {Component} from 'react';
import PropTypes from 'prop-types';
import * as API from '../api/API';

class Welcome extends Component {

    static propTypes = {
        username: PropTypes.string.isRequired,
        handleLogout: PropTypes.func.isRequired
    };

    state = {
        username: '',
        result : []
    };

    componentWillMount() {
        this.setState({
            username: this.props.username
        });

        let jsonObject = {
            documentOwner : this.props.username,
            documentPath : "/public/" + this.props.username + "/"
        };

        API.getFiles(jsonObject)
            .then((res) => {
                res.json().then((data) => {
                    console.log("In Welcome - data : " + data);
                    console.log(data);
                    this.setState({
                        result: data,
                        statusMessage: ''
                    })
                })
            });
    }

    componentDidMount() {

    };

    render() {
        return (
            <div className="row justify-content-md-center">
                <div className="col-md-3">
                    <div className="alert alert-warning" role="alert">
                        {this.state.username}, welcome to my App..!!
                    </div>

                    <div className="col-sm-9">
                        {
                            this.state.result.map((fileObject) => {
                                    return (
                                        <table className="table" key={fileObject.id}>
                                            <tbody>
                                            <tr>
                                                <td>{fileObject.documentOwner} :</td>

                                                <td>{fileObject.documentPath}</td>

                                                <td className="col-sm-3">{fileObject.documentName}</td>

                                            </tr>
                                            </tbody>
                                        </table>
                                    )
                                }
                            )
                        }
                    </div>

                    <button
                        className="btn btn-danger"
                        type="button"
                        onClick={() => this.props.handleLogout(this.state)}>
                        Logout
                    </button>
                </div>
            </div>
        )
    }
}

export default Welcome;